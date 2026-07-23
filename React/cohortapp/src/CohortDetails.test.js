import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {

  // Test 1: should create the component
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper).toBeTruthy();
  });

  // Test 2: should initialize the props
  test('should initialize the props', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.props().cohort).toEqual(CohortData[0]);
  });

  // Test 3: should display cohort code in h3
  test('should display cohort code in h3', () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.find('h3').text()).toBe(CohortData[0].code);
  });

  // Test 4: snapshot test
  test('should always render same html', () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper).toMatchSnapshot();
  });
});