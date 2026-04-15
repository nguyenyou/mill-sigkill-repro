package generated

final case class Data1339(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1339 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1339 = copy(value = value * k)
  def addTag(t: String): Data1339 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1339 = copy(meta = meta.updated(k, v))
  def merge(other: Data1339): Data1339 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1339 {
  given Ordering[Data1339] = Ordering.by(_.id)
  def empty: Data1339 = Data1339(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1339 =
    Data1339(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1339] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
