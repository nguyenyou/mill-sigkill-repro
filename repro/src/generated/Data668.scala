package generated

final case class Data668(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data668 = copy(name = name.toUpperCase)
  def scale(k: Double): Data668 = copy(value = value * k)
  def addTag(t: String): Data668 = copy(tags = t :: tags)
  def put(k: String, v: String): Data668 = copy(meta = meta.updated(k, v))
  def merge(other: Data668): Data668 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data668 {
  given Ordering[Data668] = Ordering.by(_.id)
  def empty: Data668 = Data668(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data668 =
    Data668(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data668] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
