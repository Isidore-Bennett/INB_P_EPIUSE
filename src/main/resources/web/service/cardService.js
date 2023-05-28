class CardService {
    baseUrl = "http://localhost:12345/card/";

    async _draw() {
        const requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };
        console.log("draw ")
        let data;

        await fetch(`${this.baseUrl}draw`, requestOptions)
            .then(response => response.json())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }
}

cardService = new CardService();