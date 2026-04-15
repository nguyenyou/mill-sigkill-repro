package generated

final case class Data121(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data121 = copy(name = name.toUpperCase)
  def scale(k: Double): Data121 = copy(value = value * k)
  def addTag(t: String): Data121 = copy(tags = t :: tags)
  def put(k: String, v: String): Data121 = copy(meta = meta.updated(k, v))
  def merge(other: Data121): Data121 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data121 {
  given Ordering[Data121] = Ordering.by(_.id)
  def empty: Data121 = Data121(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data121 =
    Data121(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data121] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
