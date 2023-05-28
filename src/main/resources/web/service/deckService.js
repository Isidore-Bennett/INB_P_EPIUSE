class DeckService {
    baseUrl = "http://localhost:12345/deck/";

    async _shuffle() {
        const requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };
        console.log("shuffle ")
        let data;

        await fetch(`${this.baseUrl}shuffle`, requestOptions)
            .then(response => response.json())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }

    async _newDeck() {
        const requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };
        console.log("newDeck ")
        let data;

        await fetch(`${this.baseUrl}new`, requestOptions)
            .then(response => response.json())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }

    async _getCurrentDeck() {
        const requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };
        console.log("current deck")
        let data;

        await fetch(`${this.baseUrl}current`, requestOptions)
            .then(response => response.json())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }
}

deckService = new DeckService();