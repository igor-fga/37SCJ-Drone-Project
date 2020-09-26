import React from 'react';
import './App.css';
import Form from './js/app/components/Active-drone-form'
import List from './js/app/components/Active-drone-list'
import {ContextProvider} from './js/store'

export default ()=>{
  return(
    <ContextProvider>
<center>
<table border="1px">
      <tr>
        <td>
          <Form/>
        </td>
      </tr>
      <tr>
        <td>
          <List/>
        </td>
      </tr>
    </table>
    </center>
    </ContextProvider>  

  )
}