package generated

final case class Data512(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data512 = copy(name = name.toUpperCase)
  def scale(k: Double): Data512 = copy(value = value * k)
  def addTag(t: String): Data512 = copy(tags = t :: tags)
  def put(k: String, v: String): Data512 = copy(meta = meta.updated(k, v))
  def merge(other: Data512): Data512 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data512 {
  given Ordering[Data512] = Ordering.by(_.id)
  def empty: Data512 = Data512(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data512 =
    Data512(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data512] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
