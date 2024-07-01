describe('should show user details', () => {
    it('Visits the initial project page', () => {
      cy.login('manu chahar','manu');
      cy.visit('http://localhost:4200/myprofile/304');
      cy.get('#employee-list-header').click({force:true});
      cy.url().should('include','employee');
    })
  })