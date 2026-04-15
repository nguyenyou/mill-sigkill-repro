package generated

final case class Data786(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data786 = copy(name = name.toUpperCase)
  def scale(k: Double): Data786 = copy(value = value * k)
  def addTag(t: String): Data786 = copy(tags = t :: tags)
  def put(k: String, v: String): Data786 = copy(meta = meta.updated(k, v))
  def merge(other: Data786): Data786 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data786 {
  given Ordering[Data786] = Ordering.by(_.id)
  def empty: Data786 = Data786(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data786 =
    Data786(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data786] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
