package generated

final case class Data615(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data615 = copy(name = name.toUpperCase)
  def scale(k: Double): Data615 = copy(value = value * k)
  def addTag(t: String): Data615 = copy(tags = t :: tags)
  def put(k: String, v: String): Data615 = copy(meta = meta.updated(k, v))
  def merge(other: Data615): Data615 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data615 {
  given Ordering[Data615] = Ordering.by(_.id)
  def empty: Data615 = Data615(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data615 =
    Data615(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data615] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
