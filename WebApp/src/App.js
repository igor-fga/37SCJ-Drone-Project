import React from 'react';
import './App.css';
import {Container, Row, Col} from 'reactstrap'
import DroneForm from './js/app/components/DroneForm'
import DronesList from './js/app/components/DronesList'
import {DroneContextProvider} from './js/app/store'


export default ()=>{
  return(
    <DroneContextProvider>
      <Container>
            <Row className="justify-content-center">
                <Col md="12">
                  <h1><strong>Rastreamento de Drones</strong></h1>
                  <hr className="hr"/>
                </Col>
                <DroneForm/>
                <DronesList/>
            </Row>
      </Container>
    </DroneContextProvider>  
  )
}