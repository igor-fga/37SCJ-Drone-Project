import React, {useReducer, createContext} from 'react'
export const DroneContext = createContext()

const initialState ={
    drones: []
}

const reducer = (state,action) =>{
    switch (action.type){
        case "ADD_DRONE":
            return{
                drones: [...state.drones, action.payload]
            }
        default:
            throw new Error()    
    }
}

export const DroneContextProvider = (props) =>{
    const [state, dispatch] = useReducer(reducer,initialState)
    return(
        <DroneContext.Provider value={[state,dispatch]}>
            {props.children}
        </DroneContext.Provider>
    )
}