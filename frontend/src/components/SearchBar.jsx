function SearchBar({filters, setFilters}) {
    return (
        <div>
            <input
                type="text"
                placeholder="Search by title..."
                value={filters.title}
                onChange={(e) => setFilters({...filters, title: e.target.value})}
            />
            <input
                type="text"
                placeholder="Search by author..."
                value={filters.author}
                onChange={(e) => setFilters({...filters, author: e.target.value})}
            />
            <input
                type="text"
                placeholder="Search by category..."
                value={filters.category}
                onChange={(e) => setFilters({...filters, category: e.target.value})}
            />
        </div>
    );
}

export default SearchBar;

