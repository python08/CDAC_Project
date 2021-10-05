import { URL } from '../../constants/constant';
import React, { useState ,useEffect} from "react";
import axios from 'axios';




const TeacherStdDivSubRow = ({list,index,id,teacherSubList}) => {
  //  teacherSubList[index].subject.sub_name

    return(
       
        <p> {list.standard.standardName}</p> 
       
    )

}

export default TeacherStdDivSubRow