// describe('Should login if the form is invalid', () => {
//     it('Visits the initial project page', () => {
//       cy.visit('/')
//       cy.url().should('includes','login');
//       cy.get('#username').type('manu chahar');
//       cy.get('#password').type('manu');
//       cy.get('button').click({multiple:true, force:true});
//       cy.url().should('include','myprofile/304');
//     })
//   })


describe('Should not login if the form is invalid', () => {
  it('Visits the initial project page', () => {
    cy.login('wrong username','password');
    cy.url().should('not.include','myprofile/304');
  })
})

describe('Should login if the form is valid', () => {
  it('Visits the initial project page', () => {
    cy.login('manu chahar','manu');
    cy.url().should('include','myprofile/304');
  })
})
