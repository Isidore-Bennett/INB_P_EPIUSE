class HandService {

    baseUrl = "http://localhost:12345/hand/";

    async _strength(raw) {
        console.log(raw["cards"])
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        const requestOptions = {
            method: 'POST',
            // headers: myHeaders,
            body: JSON.stringify(raw["cards"]),
            redirect: 'follow'
        };
        console.log("strength ")
        let data;

        await fetch(`${this.baseUrl}strength`, requestOptions)
            .then(response => response.json())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }
    async _current() {
        const requestOptions = {
            method: 'GET',
            redirect: 'follow'
        };
        console.log("current hand")
        let data;

        await fetch(`${this.baseUrl}current`, requestOptions)
            .then(response => response.json())
            .then(result => data = result)
            .catch(error => console.log('error', error));

        console.log(data)
        return data;
    }

}

handService = new HandService();