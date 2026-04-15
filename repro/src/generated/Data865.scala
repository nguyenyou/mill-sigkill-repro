package generated

final case class Data865(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data865 = copy(name = name.toUpperCase)
  def scale(k: Double): Data865 = copy(value = value * k)
  def addTag(t: String): Data865 = copy(tags = t :: tags)
  def put(k: String, v: String): Data865 = copy(meta = meta.updated(k, v))
  def merge(other: Data865): Data865 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data865 {
  given Ordering[Data865] = Ordering.by(_.id)
  def empty: Data865 = Data865(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data865 =
    Data865(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data865] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
