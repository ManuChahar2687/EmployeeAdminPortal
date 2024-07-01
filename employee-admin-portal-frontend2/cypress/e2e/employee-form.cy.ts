describe('should show user details if updating', () => {
    it('Visits the initial project page', () => {
      cy.login('manu chahar','manu');
      cy.visit('http://localhost:4200/myprofile/304');
      cy.get('#updateButton').click();
      cy.visit('http://localhost:4200/employee/304');
    })
  })