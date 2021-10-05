import { useParams } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { URL } from '../../../constants/constant';
import "../teacher.css"
const ViewStudentAssignment = ()=>{


   // useEffect(()=>{loadAssignment()},[])

    const [assignment,setAssignment] = useState(undefined)

    const {id}  = useParams()
    const assignmentid = {id}.id
    
    // const loadAssignment = ()=>{
        
    //      axios.get(URL + '/findstudentassignment/'+studentid).then((response)=>{
    //          const result = response.data;
    //          if(result.status === "success"){
    //              console.log(result.data)
    //             // setAssignment(result.data.assignment)
                  
    //          }else{
    //              alert("something went wrong")
    //          }
             
    //      })
    //  }
    
    return(
        <div>
            <div><img src={URL+'/'+assignmentid} className="assignmentsize" /></div>
            
        </div>
    )
}

export default ViewStudentAssignment