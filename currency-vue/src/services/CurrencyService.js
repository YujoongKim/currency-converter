import axios from 'axios';
const http = axios.create({
    baseURL : "http://localhost:8080"
});

export default{
    getAllData(){
        return http.get('/allData'); 
    },

    createData(currency) {
        return http.post('/newData', currency);
    }

}