import Fetch from 'whatwg-fetch';

export function get(url){
  return fetch(url)
  .then((response) => {
    return response.json();
  })
};

export function postUrl(url,username,password){
  return fetch(url,{
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      username: username,
      password: password
    })
  })
  .then((response) => {
    return response.json();
  })
};
