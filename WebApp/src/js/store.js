import React, {useReducer, createContext} from 'react'
export const Context = createContext()

const initialState ={
    drones: []
}

const reducer = (state,action) =>{
    switch (action.type){
        case "ADICIONAR_DRONE":
            return{
                drones: [...state.drones, action.payload]
            }
        default:
            throw new Error()    
    }
}

export const ContextProvider = (props) =>{
    const [state, dispatch] = useReducer(reducer,initialState)
    return(
        <Context.Provider value={[state,dispatch]}>
            {props.children}
        </Context.Provider>
    )
}