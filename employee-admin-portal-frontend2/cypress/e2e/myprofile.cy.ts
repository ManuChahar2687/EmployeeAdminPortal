describe('should show user details', () => {
    it('Visits the initial project page', () => {
      cy.login('manu chahar','manu');
      cy.visit('http://localhost:4200/myprofile/304')
      cy.get('#empId').should('contain.text','304');
      cy.get('#empName').should('contain.text','Manu Chahar');
      cy.get('#empEmail').should('contain.text','m.chahar2687@gmail.com');
      // cy.get('#empRole').should('contain.text','Admin');
      cy.get('#updateButton').click()
      cy.url().should('include','employee/304');
    })
  })

  describe('should show user details', () => {
    it('Visits the initial project page', () => {
      cy.login('manu chahar','manu');
      cy.visit('http://localhost:4200/myprofile/304')
      cy.get('#empId').should('contain.text','304');
      cy.get('#empName').should('contain.text','Manu Chahar');
      cy.get('#empEmail').should('contain.text','m.chahar2687@gmail.com');
      // cy.get('#empRole').should('contain.text','Admin');
      cy.get('#updateButton').click()
      cy.url().should('include','employee/304');
    })
  })

  describe('should update user details'),() => {

  }

  
