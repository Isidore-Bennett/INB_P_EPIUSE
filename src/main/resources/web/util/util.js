function renderCard(data, toDeck) {
    data.forEach((card) => {
        const cardPerspective = document.createElement("div");
        const cardContainer = document.createElement("div");
        const cardFaceContainer = document.createElement("div");
        const cardBackContainer = document.createElement("div");
        const rank = document.createElement("div");
        const rankReverse = document.createElement("div");
        const suit = document.createElement("div");

        cardPerspective.classList.add("card-perspective");
        cardContainer.classList.add("card-container");
        cardFaceContainer.classList.add("card-face-container",
            ["Hearts", "Diamonds"].includes(card["suit"])
                ? "red"
                : "black");
        cardBackContainer.classList.add("card-back-container");
        rank.classList.add("rank");
        rankReverse.classList.add("rank-reverse");
        suit.classList.add("suit");

        rank.innerText = `${card["rank"]}`;
        rankReverse.innerText = `${card["rank"]}`;
        suit.innerText = `${Suits[card["suit"]]}`;

        cardPerspective.setAttribute("card-id", card["id"]);

        cardPerspective.appendChild(cardContainer);
        cardContainer.appendChild(cardFaceContainer);
        cardFaceContainer.appendChild(rank);
        cardFaceContainer.appendChild(rankReverse);
        cardFaceContainer.appendChild(suit);
        cardContainer.appendChild(cardBackContainer);

        document.getElementById(toDeck ? "deck-container" : "hand-container").appendChild(cardPerspective);
    });
}

function clearCards(elementName) {
    document.getElementById(elementName).innerHTML = "";
}