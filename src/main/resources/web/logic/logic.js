function newDeck() {
    let topPos = 0;
    clearCards(DECK_CONTAINER);
    deckService._newDeck().then(data => {
        renderCard(data, true);

        const deckContainer = document.getElementById("deck-container");
        deckContainer.childNodes.forEach((card) => {
            card.style.top = `${topPos}px`;
            topPos += 0.5;
        })
    });
}

function shuffle() {
    deckService._shuffle().then(data => {
        clearCards(DECK_CONTAINER);
        let deckContainer = document.getElementById("deck-container");
        renderCard(data, true);
        deckContainer.childNodes.forEach((card, key) => {
            card.style.transform = `translate3d(0, -400px, 0)`;
        });

        setTimeout(() => {
            deckContainer = document.getElementById("deck-container");
            let start = ((deckContainer.childNodes.length * 10) / 2);
            deckContainer.childNodes
                .forEach((card, key) => {
                    card.style.transform = `translate3d(${-start}px, 0, 0)`;
                    card.style.top = "0px";
                    card.childNodes[0].style.transform = "rotateY(180deg)";
                    start -= 10;
                });
        }, 500);
    });
}

function updateCurrentDeck() {
    deckService._getCurrentDeck().then(data => {
        clearCards(DECK_CONTAINER);
        renderCard(data, true);

        const deckContainer = document.getElementById("deck-container");
        let start = ((deckContainer.childNodes.length * 10) / 2);
        deckContainer.childNodes
            .forEach((card, key) => {
                card.style.transform = `translate3d(${-start}px, 0, 0)`;
                card.style.top = "0px";
                card.childNodes[0].style.transform = "rotateY(180deg)";
                start -= 10;
            });
    });
}

function draw() {
    cardService._draw().then(data => {
        clearCards(HAND_CONTAINER);
        renderCard(data, false);

        const handContainer = document.getElementById("hand-container");
        let start = ((handContainer.childNodes.length * 50) / 2) - 25;
        handContainer.childNodes
            .forEach((card, key) => {
                card.style.transform = `translate3d(${-start}px, 0, 0)`;
                card.style.top = "0px";
                start -= 50;
            });

        updateCurrentDeck();
        strength();
    });
}

function strength() {
    handService._current().then(hand => {
        handService._strength(hand).then(data => {
            document.getElementById("hand-strength").innerText = data;
        });
    });
}

function getGames() {
    gameService._collection().then(data => {
        console.log(data.split(","))
        data.split(",").forEach(game => {
            const gameContainer = document.createElement("div");
            const gameSelectIndicator = document.createElement("div");
            const gameName = document.createElement("div");

            gameContainer.classList.add("game-container");
            gameSelectIndicator.classList.add("game-select-indicator");
            gameName.classList.add("game-name");

            gameName.innerText = (game + "")
                .split("_")
                .map(s => s.charAt(0).toUpperCase() + s.slice(1))
                .join(" ");

            gameContainer.onclick = () => changeGame(game);

            gameContainer.appendChild(gameSelectIndicator);
            gameContainer.appendChild(gameName);
            gameSelectIndicator.setAttribute("game", game + "");

            document.getElementById("game-select-container").appendChild(gameContainer);
        })
    })
}

function changeGame(game) {
    gameService._change(game).then(data => {
        for (let elementsByClassNameElement of document.getElementsByClassName("game-select-indicator")) {
            elementsByClassNameElement.style.background = (data + "") === elementsByClassNameElement.getAttribute("game")
                ? "green"
                : "white";
        }

        newDeck();
        clearCards(HAND_CONTAINER);
        clearCards(HAND_STRENGTH);
    })
}

function currentHand() {
    handService._current().then(data => {
        strength(data)
    });
}