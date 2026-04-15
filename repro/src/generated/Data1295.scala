package generated

final case class Data1295(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1295 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1295 = copy(value = value * k)
  def addTag(t: String): Data1295 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1295 = copy(meta = meta.updated(k, v))
  def merge(other: Data1295): Data1295 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1295 {
  given Ordering[Data1295] = Ordering.by(_.id)
  def empty: Data1295 = Data1295(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1295 =
    Data1295(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1295] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
