package core.utilities.Mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ModelMapperManager implements ModelMapperService {
	
	
	private final  ModelMapper modelMapper;
	
	
	
	public ModelMapperManager(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	}

	@Override
	public ModelMapper forResponse() {
		// TODO Auto-generated method stub
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		// TODO Auto-generated method stub
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}

}
