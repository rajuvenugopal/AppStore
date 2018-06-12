import { ProjectSassPage } from './app.po';

describe('project-sass App', () => {
  let page: ProjectSassPage;

  beforeEach(() => {
    page = new ProjectSassPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
