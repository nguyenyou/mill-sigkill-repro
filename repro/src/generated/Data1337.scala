package generated

final case class Data1337(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1337 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1337 = copy(value = value * k)
  def addTag(t: String): Data1337 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1337 = copy(meta = meta.updated(k, v))
  def merge(other: Data1337): Data1337 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1337 {
  given Ordering[Data1337] = Ordering.by(_.id)
  def empty: Data1337 = Data1337(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1337 =
    Data1337(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1337] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
