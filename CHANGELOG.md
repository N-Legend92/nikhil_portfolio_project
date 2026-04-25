# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [2026.04.24]

### Added

- Designed test suite for Clipboard component
- Designed two different use cases for Clipboard component

## [2026.04.24]

### Added

- Designed kernel implementation for Clipboard component

### Updated

- Changed design to include the actual implementation of the kernel methods
- for the clipboard component. As for overall design, nothing was really modified.
- Designed abstract class for Clipboard component

### Updated

- Changed design to include...
- Implemented all of the secondary methods toString(), equals(),
- contains(String text), oldest(), pin(int index), and removeDuplicates().
- Modified the interface to include a new kernel method, `clearEntry(int index)`
- This made implement some of the secondary methods easier
- Designed kernel and enhanced interfaces for Clipboard component

### Updated

- Changed design to include a new kernel method `entry(int index)` and added more
- secondary methods such as `pin()` and `removeDuplicates()`

## [2026.04.23]

### Added

- Designed a proof of concept for <Clipboard> component

### Updated

- Changed design to include kernel methods of
  - copy
  - paste
  - clearEntry
  - size
  - isEmpty
- As well as secondary methods of
  - contains
  - oldest
- Also designed a main method that shows of the capabilities of the component

## [2026.04.23]

### Added

- Designed DeckOfCards component
- Designed ClipBoard component
- Designed VendingMachine component
