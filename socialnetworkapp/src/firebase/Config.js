import firebase from "firebase/compat/app";

import 'firebase/compat/analytics'
import 'firebase/compat/auth';
import 'firebase/compat/firestore';

const firebaseConfig = {
  apiKey: "AIzaSyCxo0gwXcQn_tt3n-cV-qFIn_Ay-5pMSXs",
  authDomain: "messenger-ce7e6.firebaseapp.com",
  projectId: "messenger-ce7e6",
  storageBucket: "messenger-ce7e6.appspot.com",
  messagingSenderId: "120231358323",
  appId: "1:120231358323:web:2b15f19d3d068d138c9f06",
  measurementId: "G-814Z3YHEBV"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);
firebase.analytics();

const auth = firebase.auth();
const db = firebase.firestore();

export { db, auth };
export default firebase;