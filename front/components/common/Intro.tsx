import Head from 'next/head'
import Link from 'next/link'
import React from 'react'

const Intro = () => {
  
  return (
    <div>
      <Head>
       
        <title>웹사이트 소개</title>
        <style type="text/css">
        </style>
    </Head>

    <h1>웹사이트 소개 영상</h1>
    <body>
      <div>
    <iframe width="800" height="400" src="https://www.youtube.com/embed/3ERtNZqh1XA?autoplay=1&mute=1"
          title="YouTube video player" frameBorder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowFullScreen>
    </iframe>
    <style jsx>{`
            div {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
            }
        `}</style>
</div>
    </body>
    </div>
    

  )
}

export default Intro