package generated

final case class Data880(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data880 = copy(name = name.toUpperCase)
  def scale(k: Double): Data880 = copy(value = value * k)
  def addTag(t: String): Data880 = copy(tags = t :: tags)
  def put(k: String, v: String): Data880 = copy(meta = meta.updated(k, v))
  def merge(other: Data880): Data880 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data880 {
  given Ordering[Data880] = Ordering.by(_.id)
  def empty: Data880 = Data880(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data880 =
    Data880(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data880] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
