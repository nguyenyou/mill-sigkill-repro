package generated

final case class Data573(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data573 = copy(name = name.toUpperCase)
  def scale(k: Double): Data573 = copy(value = value * k)
  def addTag(t: String): Data573 = copy(tags = t :: tags)
  def put(k: String, v: String): Data573 = copy(meta = meta.updated(k, v))
  def merge(other: Data573): Data573 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data573 {
  given Ordering[Data573] = Ordering.by(_.id)
  def empty: Data573 = Data573(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data573 =
    Data573(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data573] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
