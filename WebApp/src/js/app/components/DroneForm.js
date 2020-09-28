import React, { useContext, useState } from 'react'
import { DroneContext } from '../store'
import { Col, Form, FormGroup, Label, Input, CustomInput, Button } from 'reactstrap'

export default () => {
    const idDrone = useFormInput("")
    const latitude = useFormInput("")
    const longitude = useFormInput("")
    const temperaturaAr = useFormInput("")
    const umidadeAr = useFormInput("")
    const ativarRastreamento = true
    // eslint-disable-next-line no-unused-vars
    const [state, dispatch] = useContext(DroneContext)

    const droneData = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            idDrone: idDrone.value, latitude: latitude.value, longitude: longitude.value
            , temperaturaAr: temperaturaAr.value, umidadeAr: umidadeAr.value
        })
    };

    const onSubmit = event => {
        event.preventDefault()
        dispatch({
            type: "ADD_DRONE",
            payload: {
                idDrone: idDrone.value, latitude: latitude.value, longitude: longitude.value,
                temperaturaAr: temperaturaAr.value, umidadeAr: umidadeAr.value, ativarRastreamento: ativarRastreamento.checked
            }
        })
        fetch('http://127.0.0.1:8080/drones', droneData)
            .then(response => {
                console.log("Data Saved");
            });
    };

    return (
        <Col className="form" md="4">
            <h3>Adicionar rastreamento</h3>
            <Form onSubmit={onSubmit}>
                <FormGroup>
                    <Label>ID Drone:</Label>

                    <Input {...idDrone} type="text" name="idDrone"  required autoFocus />
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
                    <Label for="exampleCheckbox">Ativar Rastreamento? </Label>
                    <div>
                        <CustomInput type="switch" id="ativarRastreamento" name="ativarRastreamento" label="Ativar"
                        />
                    </div>
                </FormGroup>


                <Button color="primary" size="lg" block>Adicionar</Button>
            </Form>
        </Col>

    )

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