package generated

final case class Data1215(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1215 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1215 = copy(value = value * k)
  def addTag(t: String): Data1215 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1215 = copy(meta = meta.updated(k, v))
  def merge(other: Data1215): Data1215 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1215 {
  given Ordering[Data1215] = Ordering.by(_.id)
  def empty: Data1215 = Data1215(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1215 =
    Data1215(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1215] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
