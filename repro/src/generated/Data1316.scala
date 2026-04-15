package generated

final case class Data1316(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1316 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1316 = copy(value = value * k)
  def addTag(t: String): Data1316 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1316 = copy(meta = meta.updated(k, v))
  def merge(other: Data1316): Data1316 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1316 {
  given Ordering[Data1316] = Ordering.by(_.id)
  def empty: Data1316 = Data1316(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1316 =
    Data1316(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1316] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
