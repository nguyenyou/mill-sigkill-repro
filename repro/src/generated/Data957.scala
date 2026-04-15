package generated

final case class Data957(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data957 = copy(name = name.toUpperCase)
  def scale(k: Double): Data957 = copy(value = value * k)
  def addTag(t: String): Data957 = copy(tags = t :: tags)
  def put(k: String, v: String): Data957 = copy(meta = meta.updated(k, v))
  def merge(other: Data957): Data957 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data957 {
  given Ordering[Data957] = Ordering.by(_.id)
  def empty: Data957 = Data957(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data957 =
    Data957(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data957] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
