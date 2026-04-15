package generated

final case class Data10(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data10 = copy(name = name.toUpperCase)
  def scale(k: Double): Data10 = copy(value = value * k)
  def addTag(t: String): Data10 = copy(tags = t :: tags)
  def put(k: String, v: String): Data10 = copy(meta = meta.updated(k, v))
  def merge(other: Data10): Data10 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data10 {
  given Ordering[Data10] = Ordering.by(_.id)
  def empty: Data10 = Data10(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data10 =
    Data10(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data10] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
