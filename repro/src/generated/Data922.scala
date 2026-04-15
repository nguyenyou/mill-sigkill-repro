package generated

final case class Data922(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data922 = copy(name = name.toUpperCase)
  def scale(k: Double): Data922 = copy(value = value * k)
  def addTag(t: String): Data922 = copy(tags = t :: tags)
  def put(k: String, v: String): Data922 = copy(meta = meta.updated(k, v))
  def merge(other: Data922): Data922 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data922 {
  given Ordering[Data922] = Ordering.by(_.id)
  def empty: Data922 = Data922(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data922 =
    Data922(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data922] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
