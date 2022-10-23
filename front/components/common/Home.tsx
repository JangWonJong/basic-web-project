import React from 'react'
import styles from '@/styles/Home.module.css'
import Link from 'next/link';

const Home: React.FC = () => {
  return (
    <div className={styles.container}>
      <div className={styles.mainText}>
        <table>
          <tbody>
            <tr>
              <td> <h1>Hello M! </h1>
              <img style={{width: 300}} src = "https://avatars.githubusercontent.com/u/97998445?v=4" alt='logo'/>
              </td>
            </tr>
          </tbody>          
          </table>
      </div>
  <section className='wrapper'>
      <article className='product1'>
        <h2>회원가입</h2>
        <p><Link href="/auth/join">회원가입하기 &raquo;</Link></p>
      </article>
      <article className='product2'>
        <h2>로그인</h2>
        <p><Link href="/auth/login">로그인창 이동 &raquo;</Link></p>
      </article>
      <article className='product3'>
        <h2>게시글 작성</h2>
        <p><Link href="/menu/services/post">게시글 작성하기 &raquo;</Link></p>
        
      </article>
      <article className='product3'>
        <h2>회원관리</h2>
        <p><Link href="/auth/update">회원 수정하기 &raquo;</Link></p>
      </article>
      
  </section>
</div>
  )
}
export default Home