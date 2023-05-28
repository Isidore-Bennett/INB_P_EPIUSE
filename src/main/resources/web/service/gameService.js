class GameService {
    baseUrl = "http://localhost:12345/game/";

    async _change(raw) {
        const requestOptions = {
            method: 'POST',
            body: raw,
            redirect: 'follow'
        };
        console.log("change ")
        let data;

        await fetch(`${this.baseUrl}change`, requestOptions)
            .then(response => response.text())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }

    async _collection() {
        const requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };
        console.log("collection ")
        let data;

        await fetch(`${this.baseUrl}collection`, requestOptions)
            .then(response => response.text())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }
}

gameService = new GameService();