import React, {useContext, useState} from 'react'
import {Context} from '../../store'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Navbar from 'react-bootstrap/Navbar';

export default()=>{
    const idDrone = useFormInput("")
    const latitude = useFormInput("")
    const longitude = useFormInput("")
    const temperaturaAr = useFormInput("")
    const umidadeAr = useFormInput("")
    const ativarRastreamento = true
    // eslint-disable-next-line no-unused-vars
    const [state,dispatch] = useContext(Context)

    const droneData = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ idDrone: idDrone.value, latitude: latitude.value, longitude: longitude.value
        , temperaturaAr: temperaturaAr.value, umidadeAr: umidadeAr.value })
    };

    const onSubmit = event =>{
        fetch('http://127.0.0.1:8080/drones', droneData)
        .then(response => response.json());
        event.preventDefault()
        dispatch({
            type: "ADICIONAR_DRONE",
            payload:{idDrone: idDrone.value, latitude: latitude.value, longitude:longitude.value, 
                temperaturaAr: temperaturaAr.value, umidadeAr: umidadeAr.value, ativarRastreamento:ativarRastreamento.value}
        })
    }

    return (
        <>
        <Navbar bg="light" expand="lg">
        <Navbar.Brand href="#home">Rastreamento de Drone</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
      </Navbar>
        <div id="drone-form">
            <center>
            <Form onSubmit={onSubmit}>
                <div className="form-group">
                    <Form.Label>ID Drone:</Form.Label>
                    <Form.Control {...idDrone} type="text" name="idDrone" placeholder="Id Drone" required autoFocus/>
                </div>
                <div className="form-group">
                    <Form.Label>Latitude:</Form.Label><br></br>
                    <Form.Control {...latitude} type="text" name="latitude" placeholder="Latitude" required />
                </div>
                <div className="form-group">
                    <Form.Label>Longitude:</Form.Label><br></br>
                    <Form.Control {...longitude} type="text" name="longitude" placeholder="Longitude" required />
                </div>
                <div className="form-group">
                    <Form.Label>Temperatura do Ar:</Form.Label><br></br>
                    <Form.Control {...temperaturaAr} type="text" name="temperaturaAr" placeholder="Temperatura do ar" required />
                </div>
                <div className="form-group">
                    <Form.Label>Umidade do Ar:</Form.Label><br></br>
                    <Form.Control {...umidadeAr} type="text" name="umidadeAr" placeholder="Umidade ar" required />
                </div>
                <Button type="submit">Ativar rastreamento</Button>
            </Form>
            </center>
        </div>
        </>
    )

}



function useFormInput(initialValue){
    const [value, setValue] = useState(initialValue)
    const handleChange = e =>{
        setValue(e.target.value)
    }
    return{
        value,
        onChange: handleChange
    }
}