package generated

final case class Data470(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data470 = copy(name = name.toUpperCase)
  def scale(k: Double): Data470 = copy(value = value * k)
  def addTag(t: String): Data470 = copy(tags = t :: tags)
  def put(k: String, v: String): Data470 = copy(meta = meta.updated(k, v))
  def merge(other: Data470): Data470 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data470 {
  given Ordering[Data470] = Ordering.by(_.id)
  def empty: Data470 = Data470(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data470 =
    Data470(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data470] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
