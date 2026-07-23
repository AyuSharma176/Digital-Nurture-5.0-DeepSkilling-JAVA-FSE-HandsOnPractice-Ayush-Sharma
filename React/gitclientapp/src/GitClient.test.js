import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    // Mock axios response
    const mockData = {
      data: [
        { name: 'repo-one' },
        { name: 'repo-two' },
        { name: 'repo-three' }
      ]
    };
    axios.get.mockResolvedValue(mockData);

    const client = new GitClient();
    const repos = await client.getRepositories('techiesyed');

    expect(repos).toEqual(['repo-one', 'repo-two', 'repo-three']);
    expect(axios.get).toHaveBeenCalledWith(
      'https://api.github.com/users/techiesyed/repos'
    );
  });
});