package com.trade_accounting.services.impl.company;

import com.trade_accounting.models.entity.company.Contact;
import com.trade_accounting.models.dto.company.ContactDto;
import com.trade_accounting.repositories.company.ContactRepository;
import com.trade_accounting.services.interfaces.company.ContactService;
import com.trade_accounting.utils.mapper.company.ContactMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactMapper contactMapper;
    private final ContactRepository contactRepository;

    @Override
    public List<ContactDto> getAll() {
        List<Contact> all = contactRepository.findAll();
        return all.stream().map(contactMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ContactDto getById(Long id) {
        Contact contact = contactRepository.getOne(id);
        return new ContactDto(contact.getId(),contact.getFullName(), contact.getPosition(), contact.getPhone(), contact.getEmail(), contact.getComment());
    }

    @Override
    public ContactDto create(ContactDto contactDto) {

        Contact contact = new Contact(contactDto.getId(),contactDto.getFullName(), contactDto.getPosition(), contactDto.getPhone(), contactDto.getEmail(), contactDto.getComment());
        contactRepository.save(contact);
        return contactDto;
    }

    @Override
    public ContactDto update(ContactDto ContactDto) {
        Contact contact = contactMapper.toModel(ContactDto);
        Contact save = contactRepository.save(contact);
        return contactMapper.toDto(save);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
