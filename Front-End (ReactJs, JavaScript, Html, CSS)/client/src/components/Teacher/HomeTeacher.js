import React, { useState ,useEffect} from "react";
import axios from 'axios';
import { useHistory} from "react-router-dom"
import { URL } from '../../constants/constant';
import { useLocation } from 'react-router';
import { useParams } from 'react-router-dom';
import "../Teacher/teacher.css"
import "../Teacher/teacher.css"
import "../user/login.css"
import { SideBarData } from './SideBarData';
import image from './images/logo.jpg'
import "../Teacher/teacher.css"
import FaceIcon from '@mui/icons-material/Face';
import "../Teacher/teacher.css"
import { SubjectBarData } from "./SubjectBarData";
import Notice from "./Pages/Notice";


const HomeTeacher = () =>{
    return(
        <div className="HomeTeacher container-fluid">
            <div className="row">
                <div className="col-sm-2 Sidebar">
                      <div className="height">
                          <div><img src={image} className="image"  /> </div> 
                          <div>Institute Name</div>
                      </div>
                      <ul className="SidebarList">
                          {SideBarData.map((val,key)=>{
                              
                              return (
                                  <li key={key} className="row"  onClick={()=>window.location.pathname = val.link}>
                                    <div className="effect" id="title" >{val.title}</div>
                                  </li>
                              );
                          })}
                      </ul>
                </div>
                <div className="col-sm-10">
                    <div className="  Bar ">
                        <div className="adjust"> 
                            <div className="m"> User Name </div>
                            <div className="m"> <FaceIcon/> </div> 
                        </div>
                    </div> 
                    <div className=" SubjectBar row">
                      {SubjectBarData.map((val,key)=>{
                          
                          return (
                              <div className="SubjectBar-row ">
                                  
                                  <div  key={key}   onClick={()=>window.location.pathname = val.link} className="effect" id="title" >
                                      {val.subject}
                                  </div>
                                  
                              </div>
                          );
                      })}
                    </div>
                   
                  
                </div>
               
            
            </div>
        </div>
    )
}

export default HomeTeacher