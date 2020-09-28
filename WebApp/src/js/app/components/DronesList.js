import React, {useContext} from 'react'
import {DroneContext} from '../store'
import {Col, Table, Alert} from 'reactstrap'

export default()=>{
    const [state] = useContext(DroneContext);
    const length = state.drones.length;
    const rows = state.drones.map((drone, index) => 
        <tr key={index}>
            <td>{drone.idDrone}</td>
            <td>{drone.latitude}</td>
            <td>{drone.longitude}</td>
            <td>{drone.temperaturaAr}</td>
            <td>{drone.umidadeAr}</td>
            <td><a target="_blank" href="https://www.google.com/maps/search/?api=1&query=47.5951518,-122.3316393">Ver</a></td>
        </tr>
    )
    if (state.drones.length > 0) {
        return (
            <Col md="8">
                <h3>Drones rastreados</h3>
                    <Table striped>
                        <thead>
                            <tr>
                                <td>Id Drone</td>
                                <td>Latitude</td>
                                <td>Longitude</td>
                                <td>Temperatura Ar</td>
                                <td>Umidade Ar</td>
                                <td>Rastreamento</td>
                            </tr>
                        </thead>
                        <tbody>
                            {rows}
                        </tbody>
                    </Table>
    
            </Col>
        )
    } else {
        return (
            <Col md="8">
                <h3>Drones rastreados</h3>
                <Alert color="info">Nenhum drone rastreado no momento.</Alert>
            </Col>
        )
    }
}