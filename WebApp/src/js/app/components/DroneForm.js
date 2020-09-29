import React, { useContext, useState } from 'react'
import { DroneContext } from '../store'
import { Col, Form, FormGroup, Label, Input, CustomInput, Button } from 'reactstrap'

export default () => {
    const idDrone = useFormInput("")
    const latitude = useFormInput("")
    const longitude = useFormInput("")
    const temperaturaAr = useFormInput("")
    const umidadeAr = useFormInput("")
    const ativarRastreamento = useFormInputChecked("")
    // eslint-disable-next-line no-unused-vars
    const [state, dispatch] = useContext(DroneContext)

    const request = (data) => {
        fetch('http://127.0.0.1:8080/drones', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        })
            .then(response => {
                console.log("Data Saved");
            }); 
    }

    const onSubmit = event => {

        let interval;
        
        const data = {
            idDrone: idDrone.value, latitude: latitude.value, longitude: longitude.value,
            temperaturaAr: temperaturaAr.value, umidadeAr: umidadeAr.value, ativarRastreamento: ativarRastreamento.value
        }

        event.preventDefault()
        dispatch({
            type: "ADD_DRONE",
            payload: data
        })
        request(data);

        interval = setInterval(() => {
            data.temperaturaAr = Math.floor((Math.random() * 40) + 1);
            data.umidadeAr = Math.floor((Math.random() * 100) + 1);
            request(data);
        }, 10000);

    };



    return (
        <Col className="form" md="4">
            <h3>Adicionar rastreamento</h3>
            <Form onSubmit={onSubmit}>
                <FormGroup>
                    <Label>ID Drone:</Label>

                    <Input {...idDrone} type="text" name="idDrone" required autoFocus />
                </FormGroup>
                <FormGroup>
                    <Label>Latitude:</Label>
                    <Input {...latitude} type="text" name="latitude" required />
                </FormGroup>
                <FormGroup>
                    <Label>Longitude:</Label>
                    <Input {...longitude} type="text" name="longitude" required />
                </FormGroup>
                <FormGroup>
                    <Label>Temperatura do Ar:</Label>
                    <Input {...temperaturaAr} type="text" name="temperaturaAr" required />
                </FormGroup>
                <FormGroup>
                    <Label>Umidade do Ar:</Label>
                    <Input {...umidadeAr} type="text" name="umidadeAr" required />
                </FormGroup>
                <FormGroup>
                    <Label for="exampleCheckbox">Ativar Rastreamento?</Label>
                    <div>
                        <CustomInput {...ativarRastreamento} type="switch" id="ativarRastreamento" name="ativarRastreamento" 
                        value="true"/>
                    </div>
                </FormGroup>


                <Button color="primary" size="lg" block>Adicionar</Button>
            </Form>
        </Col>

    )

}

function useFormInputChecked(initialValue) {
    const [value, setValue] = useState(initialValue)
    const handleChange = e => {
        setValue(e.target.checked)
    }
    return {
        value,
        onChange: handleChange
    }
}

function useFormInput(initialValue) {
    const [value, setValue] = useState(initialValue)
    const handleChange = e => {
        setValue(e.target.value)
    }
    return {
        value,
        onChange: handleChange
    }
}