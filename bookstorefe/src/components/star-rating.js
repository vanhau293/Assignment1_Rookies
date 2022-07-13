import React from "react";
import ReactStars from "react-rating-stars-component";
export default function Star(props){
    const firstExample = {
      size: 30,
      value: props.star,
      edit: false
    };
    return (<>
      <ReactStars {...firstExample} />
      </>
      
    );
  }