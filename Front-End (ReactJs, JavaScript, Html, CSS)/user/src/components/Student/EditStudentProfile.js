import { useState, useEffect } from 'react';
import { useParams, useHistory } from 'react-router-dom';
import axios from 'axios';
import "./teacher.css"
import "./login.css"
import { URL } from '../../constants/constant';

const EditStudentProfile = ()=>{

    useEffect(()=>{loadStudentStandardDivSub()},[])
    const {studentid}  = useParams()
    const studentId = {studentid}.studentid

    const {id}  = useParams()
    const instituteId = {id}.id
    

    const [studentName,setStudentName] = useState("")
    const [instituteName,setInstituteName] = useState("")
    const [instititeInfo,setInstituteInfo] = useState("") 
    const [studentPhoto,setStudentPhoto] = useState(undefined)
    const [editPhoto,setPhoto] = useState(undefined)
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [mobile, setMobile] = useState(""); 
    const [institutePhoto,setInstitutePhoto] = useState(undefined)

    const body = new FormData()
    const history = useHistory()
    
    const loadStudentStandardDivSub = ()=>{

        axios.get(URL + '/finduser/'+ studentId).then((response)=>{
          const result = response.data;
          console.log(result)
          setInstitutePhoto(result.instituteid.profilepicture)
          console.log(result.teacherStdDivList)
          setInstituteName(result.instituteid.name) 
          setInstituteInfo(result.instituteid)
          setStudentName(result.firstname + " "+ result.lastname)
          setStudentPhoto(result.profilepicture)
         
      })
    }
   console.log(instititeInfo)
   const logout = () => {

    alert("You are Logged out, see you")
    history.push("/");

}

const onFileSelect =(event)=>{
    const file = event.target.files[0]
    setPhoto(file)
}

 const editprofile = (e)=>{
    e.preventDefault();
    // add the data
   
    if(mobile.length>10 && mobile.length<10)
       alert("Please check number you have entered")
    else
       setMobile(mobile)
   
    body.append('id',studentId)
    body.append('password',password)
    body.append('username',username)
    body.append('firstname',firstname)
    body.append('lastname',lastname)
    body.append('mobile',mobile)
    body.append('profilepicture',editPhoto)

   
    axios.post(URL + '/updateprofile',body).then((response)=>{
        const result = response.data;
        console.log(result)
        if(result.status === "success"){
          alert("Successfully saved user")
          window.location.reload(false)
        }
        else
          alert("Unsuccessful ")
    })
   
 }


    return(
        <div>
            
            <div className="row row-height" >
            <div className="col-sm-2 Sidebar">
            <div className="height">
                          <div><img src={URL+"/"+institutePhoto} className="image"  /> </div> 
                          <div className="text-white">{instituteName}</div>
                        </div>
                        <ul className="SidebarList" >
                        <li className="row"  >
                            <div className="effect" id="title"  ><a className="text-light" href={"/studentdash/"+ studentid + "/" + id } >   Dashboard </a>  </div>
                        </li>
                        <li className="row"  >
                                  <div className="effect" id="title"  ><a className="text-light" href={"/studenttimetable/"+ studentid + "/" + id } >Timetable</a></div>
                        </li>
                        <li className="row"  >
                                  <div className="effect" id="title"  ><a className="text-light" href={"/studentnotice/"+ studentid + "/"+ id } >Notice</a></div>
                        </li>
                        <li className="row"  >
                                  <div className="effect" id="title"  ><a className="text-light" href={"/studentprofile/"+ studentid + "/"+ id } >Profile</a></div>
                        </li>
                        <li className="row"  >
                                  <div className="effect" id="title"  ><a className="text-light" href={"/studenthelp/"+ studentid + "/"+ id } >Help</a></div>
                        </li>
                        <li className="row"  >
                                  <div className="effect text-light" id="title" onClick={logout}  >logout</div>
                        </li>
                
                      </ul>
            </div>
            <div className="col-sm-10 p-0">
            <div className="  Bar ">
                        <div className="adjust">
                        
                           
                            <div className="m name">{studentName} </div>
                            <div className="m"> <img   src={URL+'/'+studentPhoto} className="profile-bar"  /> </div> 
                        </div>
            </div> 
            <div className=" SubjectBar row">

                              <div className="SubjectBar-row ">
                                  
                                  <div  className="effect" id="title"  >
                                      Edit Profile
                                  </div>
                                  
                              </div>
                   
            </div>
            <div className="help container">
                     <div className="row">
                         <div className="col-lg-4 profile-height1">
                             <div>
                                    <img   src={URL+'/'+studentPhoto} className="profile-height-photo"  /> 
                                    <div className="profile-line-spacing ">
                                    <input accept="image/*" onChange={onFileSelect} type="file" className="form-control "/>
                                    </div>  
                             </div>
                        </div>
                         <div className="col-lg-8 profile-height1">
                             <div>
                             <table >
                                   
                                    <tr className="profile-line-spacing">
                                       <td >  <label className="form-label text-white profile-line-spacing" >username:</label> </td>
                                       <td>   <input className="borderRadius profile-line-spacing"  type="text" value={username} onChange={e => setUsername(e.target.value)} />  </td>
                                    </tr>
                                    <tr >
                                       <td>  <label className="form-label text-white profile-line-spacing" >firstname:</label> </td>
                                       <td>   <input className="borderRadius profile-line-spacing"  type="text" value={firstname} onChange={e => setFirstname(e.target.value)} />  </td>
                                    </tr>
                                    <tr >
                                       <td>  <label className="form-label text-white profile-line-spacing" >lastname:</label> </td>
                                       <td>   <input className="borderRadius profile-line-spacing"  type="text" value={lastname} onChange={e => setLastname(e.target.value)} />  </td>
                                    </tr>
                                     
                                    <tr >
                                       <td>  <label className="form-label text-white profile-line-spacing" >Password:</label> </td>
                                       <td>   <input className="borderRadius profile-line-spacing"  type="password" value={password} onChange={e => setPassword(e.target.value)} />  </td>
                                    </tr>
                                   
                                    <tr >
                                       <td>  <label className="form-label text-white profile-line-spacing" >mobile:</label> </td>
                                       <td>   <input className="borderRadius profile-line-spacing"  type="text" value={mobile} onChange={e => setMobile(e.target.value)} />  </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <button onClick={editprofile} className="btn btn-outline-light btn-sm px-5 profile-line-spacing" type="submit" > submit</button>
                                        </td>
                                    
                                    </tr>
                                    </table>
                             </div>
                             
                         </div>
                         <div className="col-lg-12 ">
                                
                         </div>
                     </div>
            </div>
            </div>
            </div>
        
    </div>
    )

}

export default EditStudentProfile