package generated

final case class Data96(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data96 = copy(name = name.toUpperCase)
  def scale(k: Double): Data96 = copy(value = value * k)
  def addTag(t: String): Data96 = copy(tags = t :: tags)
  def put(k: String, v: String): Data96 = copy(meta = meta.updated(k, v))
  def merge(other: Data96): Data96 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data96 {
  given Ordering[Data96] = Ordering.by(_.id)
  def empty: Data96 = Data96(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data96 =
    Data96(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data96] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
