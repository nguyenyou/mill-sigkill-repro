package generated

final case class Data216(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data216 = copy(name = name.toUpperCase)
  def scale(k: Double): Data216 = copy(value = value * k)
  def addTag(t: String): Data216 = copy(tags = t :: tags)
  def put(k: String, v: String): Data216 = copy(meta = meta.updated(k, v))
  def merge(other: Data216): Data216 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data216 {
  given Ordering[Data216] = Ordering.by(_.id)
  def empty: Data216 = Data216(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data216 =
    Data216(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data216] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
